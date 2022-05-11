package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateRemoteDTO;
import nl.camiel.novi.backend.TechItEasy.domain.dto.RemoteDTO;
import nl.camiel.novi.backend.TechItEasy.domain.entity.Remote;
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


    @GetMapping("{id}")
    public ResponseEntity<RemoteDTO> remoteDTO (@PathVariable Long id){
        RemoteDTO remoteDTO = remoteService.getRemoteById(id);
        return ResponseEntity.ok(remoteDTO);
    }

    @PostMapping
    public ResponseEntity<Remote> remote (@RequestBody CreateRemoteDTO createRemoteDTO) {
      final Remote remote = remoteService.toRemote(createRemoteDTO);

        final URI location = URI.create("/remotes/" + remote.getId());
        return ResponseEntity
                .created(location)
                .body(remote);
    }

}
