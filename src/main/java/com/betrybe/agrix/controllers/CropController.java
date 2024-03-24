package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* CropController.
*/
public class CropController {
  private final CropService cropService;
    
  /**
  * Constructs a new FarmController with the specified FarmService.
  */
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
  * Gets all crops.
  */
  @GetMapping("/crops")
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<Crop> crops = cropService.getAllCrops();
    List<CropDto> cropDtos = CropDto.toList(crops);
    return ResponseEntity.ok(cropDtos);
  }
  
  // /**
  //  * Returns a list of all crops.
  //  */
  // @GetMapping("/crops")
  // public ResponseEntity<List<CropDto.ToResponse>> getAllCrops() {
  //   List<Crop> crops = farmService.getAllCrops();
  //   List<CropDto.ToResponse> cropDtos = mapToCropDtoList(crops);
  //   return ResponseEntity.ok().body(cropDtos);
  // }

  // /**
  //  * Retrieves a specific crop by its ID.
  // */
  // @GetMapping("/crops/{id}")
  // public ResponseEntity<?> getCropById(@PathVariable Long id) {
  //   Optional<Crop> cropOptional = farmService.getCropById(id);

  //   if (cropOptional.isEmpty()) {
  //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plantação não encontrada!");
  //   }

  //   CropDto.ToResponse response = CropDto.fromEntity(cropOptional.get());
  //   return ResponseEntity.ok(response);
  // }


  // private List<CropDto.ToResponse> mapToCropDtoList(List<Crop> crops) {
  //   return crops.stream()
  //   .map(CropDto::fromEntity)
  //   .collect(Collectors.toList());
  // }
}
