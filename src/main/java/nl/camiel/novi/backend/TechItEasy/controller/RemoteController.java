package nl.camiel.novi.backend.TechItEasy.controller;

import nl.camiel.novi.backend.TechItEasy.domain.dto.CreateRemoteDTO;
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



    @PostMapping
    public ResponseEntity<Remote> remote (@RequestBody CreateRemoteDTO createRemoteDTO) {
      final Remote remote = remoteService.toRemote(createRemoteDTO);

        return ResponseEntity
                .created(null)
                .body(remote);
    }

}
