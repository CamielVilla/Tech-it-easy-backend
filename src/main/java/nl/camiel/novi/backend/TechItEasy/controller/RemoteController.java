package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateRemote;
import nl.camiel.novi.backend.TechItEasy.domain.dto.IdInputDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.RemoteDTO;
import nl.camiel.novi.backend.TechItEasy.service.RemoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("remotes")
public class RemoteController {

    private final RemoteService remoteService;

    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }



    @PostMapping
    public ResponseEntity<RemoteDTO> remoteDTO (@RequestBody CreateRemote createRemote) {
        final RemoteDTO remoteDTO = remoteService.createRemote(createRemote);

        final URI location = URI.create("/remotes" + remoteDTO.getId());
        return ResponseEntity
                .created(location)
                .body(remoteDTO);
    }

    @PutMapping("remotes/{id}/televisions")
    public ResponseEntity<RemoteDTO> remoteDTO (@PathVariable Long televisionId, @RequestBody IdInputDTO input) {
        return null;
    }

}
