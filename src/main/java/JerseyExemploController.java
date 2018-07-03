/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("webservice")
public class JerseyExemploController {

    static TortaDAO tortaDAO;

    public JerseyExemploController() {
        tortaDAO = new TortaDAO();
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Vamos comecar!";
    }

    // http://localhost:8084/application/webservice/insert?sabor=chocolate&camadasDeRecheio=2&fabricante=bia
    @POST
    @Path("insert")
    @Produces(MediaType.TEXT_PLAIN)
    public Response adicionar(@QueryParam("sabor") String nome,
            @QueryParam("id") int id,
            @QueryParam("fabricante") String fabricante) {
        Torta torta = new Torta(nome, id, fabricante);
        Gson gson = new Gson();
        Boolean resultado = new Boolean(this.tortaDAO.insert(torta));
        return Response.status(Status.OK).entity(gson.toJson(resultado)).build();
    }

    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@QueryParam("id") int id) {
        Gson gson = new Gson();
        Boolean resultado = new Boolean(this.tortaDAO.delete(id));
        return Response.status(Status.OK).entity(gson.toJson(resultado)).build();
    }

    @GET
    @Path("get")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@QueryParam("sabor") String nome,
            @QueryParam("camadasDeRecheio") int camadasDeRecheio,
            @QueryParam("fabricante") String fabricante) {
        Torta torta = new Torta(nome, camadasDeRecheio, fabricante);
        Gson gson = new Gson();
        Torta t = new Torta();
        t = this.tortaDAO.get(torta);

        return gson.toJson(t);
    }

    @GET
    @Path("getId")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@QueryParam("id") int id) {
        Gson gson = new Gson();
        Torta t = new Torta();
        t = this.tortaDAO.getId(id);

        return gson.toJson(t);
    }

}
