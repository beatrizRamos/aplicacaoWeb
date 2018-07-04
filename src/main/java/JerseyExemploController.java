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
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

    private TortaDAO tortaDAO;

    public JerseyExemploController() {
        tortaDAO = TortaDAO.getInstance();
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

    // http://localhost:8084/application/webservice/insert?sabor=chocolate&id=2&fabricante=bia
    @POST
    @Path("insert")
    @Produces(MediaType.TEXT_PLAIN)
    public String insert(@QueryParam("sabor") String sabor,
            @QueryParam("id") int id,
            @QueryParam("fabricante") String fabricante) {
        Torta torta = new Torta(sabor, id, fabricante);
        Gson gson = new Gson();

        return gson.toJson(this.tortaDAO.insert(torta));
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
    public String get(@QueryParam("sabor") String sabor,
            @QueryParam("id") int id,
            @QueryParam("fabricante") String fabricante) {
        Torta torta = new Torta(sabor, id, fabricante);
        Gson gson = new Gson();

        return gson.toJson(this.tortaDAO.get(torta));
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

    @GET
    @Path("listAll")
    @Produces(MediaType.TEXT_PLAIN)
    public String listAll() {

        Gson gson = new Gson();
        return gson.toJson(this.tortaDAO.listAll());
    }

    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public String update(@QueryParam("sabor") String sabor,
            @QueryParam("id") int id,
            @QueryParam("fabricante") String fabricante) {
        Torta torta = new Torta(sabor, id, fabricante);
        Gson gson = new Gson();
        return gson.toJson(this.tortaDAO.update(torta));
    }

}
