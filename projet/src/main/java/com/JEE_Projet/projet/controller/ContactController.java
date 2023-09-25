package com.JEE_Projet.projet.controller;

import com.JEE_Projet.projet.model.Contact;
import com.JEE_Projet.projet.response.ResponseHandler;
import com.JEE_Projet.projet.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Operation(summary = "Get all contacts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the contacts", content =  @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"data\": [{\"id\": 1,\"firstname\": \"John\",\"lastname\": \"Doe\",\"gender\": \"male\",\"birthdate\": \"1990-01-01\",\"email\": \"john.doe@example.com\",\"phone\": \"0123456789\",\"origin_country\": \"France\",\"living_country\": \"USA\"},{\"id\": 2,\"firstname\": \"Manuel\",\"lastname\": \"Lo\",\"gender\": \"male\",\"birthdate\": \"1997-04-25\",\"email\": \"manuello@example.com\",\"phone\": \"0167548189\",\"origin_country\": \"Spain\",\"living_country\": \"Portugal\"}],\"message\":\"Successfully fetched contacts\",\"status\": 200}"))),
    })
    public ResponseEntity<Object> getAll() {
        try {
            List<Contact> result = contactService.getAll();
            return ResponseHandler.generateResponse("Successfully fetched contacts", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Operation(summary = "Get a contact by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the contact", content =  @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"data\": {\"id\": 1,\"firstname\": \"John\",\"lastname\": \"Doe\",\"gender\": \"male\",\"birthdate\": \"1990-01-01\",\"email\": \"john.doe@example.com\",\"phone\": \"0123456789\",\"origin_country\": \"France\",\"living_country\": \"USA\"},\"message\":\"Successfully fetched contact\",\"status\": 200}"))),
            @ApiResponse(responseCode = "404", description = "Contact not found", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"data\": null,\"message\":\"Contact not found\",\"status\": 404}")))
    })
    public ResponseEntity<Object> getOne(@PathVariable Integer id) {
        try {
            Contact result = contactService.getOne(id);

            if (result == null)
                return ResponseHandler.generateResponse("Contact not found", HttpStatus.NOT_FOUND, null);

            return ResponseHandler.generateResponse("Successfully fetched contact", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    @Operation(summary = "Create a new contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the contact", content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"data\": {\"id\": 1,\"firstname\": \"John\",\"lastname\": \"Doe\",\"gender\": \"male\",\"birthdate\": \"1990-01-01\",\"email\": \"john.doe@example.com\",\"phone\": \"0123456789\",\"origin_country\": \"France\",\"living_country\": \"USA\"},\"message\":\"Successfully created contact\",\"status\": 200}"))),
            @ApiResponse(responseCode = "422", description = "Invalid input", content = @Content)
    })
    public ResponseEntity<Object> create(@RequestBody Contact contact) {
        try {
            Contact result = contactService.create(contact);

            return ResponseHandler.generateResponse("Successfully created contact", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @Operation(summary = "Delete a contact by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the contact", content = @Content),
            @ApiResponse(responseCode = "404", description = "Contact not found", content = @Content)
    })
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            String result = contactService.delete(id);

            if (result == null)
                return ResponseHandler.generateResponse("Contact not found", HttpStatus.NOT_FOUND, null);

            return ResponseHandler.generateResponse("Successfully deleted contact", HttpStatus.NO_CONTENT, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}