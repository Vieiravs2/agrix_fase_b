package com.betrybe.agrix.services;

import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;

  /**
   * Constructs a new CropService with the specified CropRepository.
   */
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  /**
  * getAllCrops.
  */
  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  /**
  * getCropById.
  */
  public Crop getCropById(Long id) {
    Optional<Crop> crop = cropRepository.findById(id);

    if (!crop.isEmpty()) {
      return crop.get();
    }

    throw new FarmNotFoundException("Plantação não encontrada!");
  }
}