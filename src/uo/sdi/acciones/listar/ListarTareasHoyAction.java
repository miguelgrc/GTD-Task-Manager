package uo.sdi.acciones.listar;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.acciones.Accion;
import uo.sdi.acciones.comparators.TodayTaskComparator;
import uo.sdi.acciones.tipos.ListType;
import uo.sdi.business.Services;
import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import alb.util.log.Log;

/**
 * Devuelve el conjunto de tareas pendientes para hoy tomando el usuario en sesión.
 * Eso significa que el usuario tiene que estar identificado previamente (sin problema ya que
 * si accede a esta acción significa que se ha logeado correctamente).
 */
public class ListarTareasHoyAction implements Accion {
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String resultado="EXITO";
		
		List<Task> listaHoy;
		
		try {
			TaskService taskService = Services.getTaskService();
			HttpSession session = request.getSession();
			User user =(User)session.getAttribute("user");
			listaHoy=taskService.findTodayTasksByUserId(user.getId());
			Collections.sort(listaHoy, new TodayTaskComparator());
			request.setAttribute("listaMostrar", listaHoy);
			
			Log.debug("Obtenida lista de tareas para hoy con [%d] tareas", 
					listaHoy.size());
			
			resultado = new ListarCategoriasAction().execute(request, response);
			
			session.setAttribute("ultimaLista", ListType.Hoy);
			request.setAttribute("nombreCat", "Hoy");
		}
		catch (BusinessException b) {
			Log.debug("Algo ha ocurrido obteniendo lista de tareas para hoy: %s",
					b.getMessage());
			resultado="FRACASO";
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
