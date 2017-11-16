/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.api;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author smaicon
 */
@Path("ws")
public class WsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WsResource
     */
    public WsResource() {
    }

    /**
     * Retrieves representation of an instance of
     * br.senac.donc.webService.WsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("vereador/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listVereador() {
        List<Vereador> lista;

        VereadorDAO dao = new VereadorDAO();
        lista = dao.listar();

        //converter para Json
        Gson g = new Gson();
        return g.toJson(lista);

    }

    //recall tens que usar lista vereadores;
    //precisa comecar com lista vereadores;
    @GET
    @Path("balancete/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listBalancete() {
        List<Balancete> lista;

        BalanceteDAO dao = new BalanceteDAO();
        lista = dao.listar();

        //converter para Json
        Gson g = new Gson();
        return g.toJson(lista);

    }

    @GET
    @Path("gastos_vereador/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listGastos() {
        List<Gasto> lista;

        GastosDAO dao = new GastosDAO();
        lista = dao.listarGastos();

        System.out.println("########################################### " + lista);
        Gson g = new Gson();
        return g.toJson(lista);

    }

   

    /**
     * PUT method for updating or creating an instance of WsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
