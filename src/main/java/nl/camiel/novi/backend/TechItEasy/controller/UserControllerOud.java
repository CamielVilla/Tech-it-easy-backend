//package nl.camiel.novi.backend.TechItEasy.controller;
//
//import nl.camiel.novi.backend.TechItEasy.Exception.RecordNotFoundException;
//import nl.camiel.novi.backend.TechItEasy.models.ScreenType;
//import nl.camiel.novi.backend.TechItEasy.models.TechItEasy;
//import nl.camiel.novi.backend.TechItEasy.domain.Television;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/tvs")
//public class UserControllerOud {
//
//    @GetMapping
//    public ResponseEntity<List<Television>> getAllTvs() {
//        final Television phillips4K = new Television("phillips", "4K TV", 379, ScreenType.LED);
//        final Television NikkeiHdSmart = new Television("Nikkei", "HD Smart TV", 159, ScreenType.LED);
//        final Television Samsung4KQLed = new Television("Samsung", "4K QLED TV", 709, ScreenType.QLED);
//        final TechItEasy techItEasy = new TechItEasy("Tech It Easy");
//        techItEasy.addTv(phillips4K);
//        techItEasy.addTv(NikkeiHdSmart);
//        techItEasy.addTv(Samsung4KQLed);
//        final List<Television> allTelevisions = techItEasy.getAllTvsList();
//        return ResponseEntity.ok((allTelevisions));
//    }
//
//    @GetMapping("{name}")
//    public ResponseEntity<Television> getTvByName(@PathVariable String name){
//          if (name.equals("4KTV") ) {
//              return ResponseEntity.ok(new Television("phillips", "4K TV", 379, ScreenType.LED));
//          }
//            else {
//              throw new RecordNotFoundException("Tv bestaat niet");
//
//          }
//    }
//
//    @PostMapping
//    public ResponseEntity<Television> addTv(@RequestBody Television television) {
//    television.getName();
//    return ResponseEntity.created(null).build();
//    }
//
//
//    @PutMapping("{name}")
//    public ResponseEntity<Television> updateTv(@PathVariable String name, @RequestBody String newName) {
//        return (ResponseEntity<Television>) ResponseEntity.noContent();
//    }
//
//}
//
//
