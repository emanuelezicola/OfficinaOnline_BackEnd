package it.project.alpha.web.rest.resources;

import it.project.alpha.costants.RuoliCodice;
import it.project.alpha.model.Ruolo;
import it.project.alpha.model.Utente;
import it.project.alpha.service.ruolo.RuoloService;
import it.project.alpha.service.utente.UtenteService;
import it.project.alpha.web.dto.WSOutput.WsOutputDTO;
import it.project.alpha.web.dto.utente.UtenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Path("/utente")
@CrossOrigin

public class UtenteResource {


    @Autowired
    private UtenteService utenteService;

    @Autowired
    private RuoloService ruoloService;

    private static WsOutputDTO wsOutputDTO = new WsOutputDTO();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUtente(@PathParam("id") Long id){

        if(id==null || id<=0){
            wsOutputDTO.setStatus(false);
            wsOutputDTO.setMessage("Nessun utente trovato");
            return Response.status(Response.Status.NOT_FOUND).entity(wsOutputDTO).build();
        }

        Utente utente = utenteService.caricaSingoloUtente(id);

        if(utente==null){
            wsOutputDTO.setStatus(false);
            wsOutputDTO.setMessage("Nessun utente trovato");
            return Response.status(Response.Status.NOT_FOUND).entity(wsOutputDTO).build();
        }

        UtenteDTO result = new UtenteDTO();
        result.createDTO(utente);

        wsOutputDTO.setStatus(true);
        wsOutputDTO.setObj(result);

        return Response.status(200).entity(wsOutputDTO).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchAll(){
        List<Utente> utenti = utenteService.listAllUtenti();

        if(utenti.isEmpty()){
            wsOutputDTO.setMessage("Nessun utente trovatyo");
            wsOutputDTO.setStatus(false);
            return Response.status(404).entity(wsOutputDTO).build();
        }

        List<UtenteDTO> result = utenti.stream()
                .map(x -> {
                    UtenteDTO utenteDTO = new UtenteDTO();
                    utenteDTO.createDTO(x);
                    return utenteDTO;
                }).collect(Collectors.toList());

        wsOutputDTO.setStatus(true);
        wsOutputDTO.setObj(result);

        return Response.status(200).entity(wsOutputDTO).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registraNuovoUtente(UtenteDTO utenteDTO){


        Map<String, String> errors = utenteDTO.validate();

        if(!errors.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
        }

        Utente verificaEmail = utenteService.findByEmail(utenteDTO.getEmail());

        if(verificaEmail != null ){
            wsOutputDTO.setMessage("Email già in uso per l'input " +  utenteDTO.getEmail());
            wsOutputDTO.setStatus(false);
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(wsOutputDTO).build();
        }

        Ruolo ruolo = ruoloService.findByCodice(RuoliCodice.USER_COD);

        if(ruolo==null){
            wsOutputDTO.setStatus(false);
            wsOutputDTO.setMessage("Oops! Errore interno!");
            return Response.status(500).entity(wsOutputDTO).build();
        }

        Utente utente = new Utente(utenteDTO.getNome(), utenteDTO.getCognome(), utenteDTO.getEmail(), utenteDTO.getPassword());
        utente.setDataRegistrazione(new Date());
        utente.setRuoli(new HashSet<>(Arrays.asList(ruolo)));

        utenteService.inserisciNuovo(utente);

        //TODO Send mail con informazione che l'utente è registrato
        wsOutputDTO.setStatus(true);
        wsOutputDTO.setMessage("Utente registrato con successo");
        return Response.status(200).entity(wsOutputDTO).build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UtenteDTO utenteDTO){

        if(utenteDTO==null){
            wsOutputDTO.setStatus(false);
            wsOutputDTO.setMessage("Errore");
            return Response.status(Response.Status.BAD_REQUEST).entity(wsOutputDTO).build();
        }

        Map<String, String> errors = utenteDTO.validateForLogin();
        if(!errors.isEmpty()){
            wsOutputDTO.setStatus(false);
            wsOutputDTO.setObj(errors);
            return Response.status(Response.Status.BAD_REQUEST).entity(wsOutputDTO).build();
        }

        Utente user = utenteService.eseguiAccesso(utenteDTO.getEmail(), utenteDTO.getPassword());

        if(user == null) {
            wsOutputDTO.setStatus(Boolean.FALSE);
            wsOutputDTO.setObj("Nessun utente trovato con le credenziali fornite!");
            wsOutputDTO.setMessage(Response.Status.NOT_FOUND.toString());
            return Response.status(Response.Status.OK).entity(wsOutputDTO).build();
        }
        UtenteDTO output = new UtenteDTO();
        output.createDTO(user);

        wsOutputDTO.setStatus(true);
        wsOutputDTO.setObj(output);



        return Response.status(200).entity(wsOutputDTO).build();
    }


}
