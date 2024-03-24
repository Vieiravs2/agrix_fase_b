package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crop;

/**
 * Crop DTO.
 */
public record CropDto(Long id, String name, Double plantedArea, Long farmId) {
  /**
  * toCrop.
  */
  public Crop toCrop() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    return crop;
  }
  
  /**
  * ToResponse.
  */
  public static record ToResponse(Long id, String name, double plantedArea, Long farmId) {
  
  }

  /**
  * fromEntity.
  */
  public static ToResponse fromEntity(Crop crop) {
    return new ToResponse(crop.getId(), crop.getName(), crop.getPlantedArea(), crop
      .getFarm().getId());
  }
  
  /**
  * toEntity.
  */
  public Crop toEntity() {
    return new Crop(id, name, plantedArea, null);
  }
}