package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* CropController.
*/
@RestController
@RequestMapping()
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

  /**
   * Retrieves a specific crop by its ID.
  */
  @GetMapping("/crops/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long id) {
    Crop crop = cropService.getCropById(id);
    CropDto cropDto = CropDto.toDto(crop);
    return ResponseEntity.ok(cropDto);
  }

  /**
   * Search Crop by start and end date.
  */
  @GetMapping("/crops/search")
  public ResponseEntity<List<CropDto>> getCropByHarvestDate(
      @RequestParam(name = "start") LocalDate start,
      @RequestParam(name = "end") LocalDate end
  ) {
    List<Crop> crops = cropService.searchCrop(start, end);
    List<CropDto> cropDtos = CropDto.toList(crops);
    return ResponseEntity.ok(cropDtos);
  }


  // private List<CropDto.ToResponse> mapToCropDtoList(List<Crop> crops) {
  //   return crops.stream()
  //   .map(CropDto::fromEntity)
  //   .collect(Collectors.toList());
  // }
}
