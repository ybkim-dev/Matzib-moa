package com.project.matzibmoa.domain.store.domain.repository;

import com.project.matzibmoa.domain.store.domain.entity.Store;
import com.project.matzibmoa.domain.store.dto.StoreSearchResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store, Long> {

  @Query(value = "SELECT *,  ST_Distance_Sphere(Point(:longitude, :latitude), POINT(longitude, latitude)) as distance "
      + "FROM store "
      + "WHERE ST_Distance_Sphere(Point(:longitude, :latitude), POINT(longitude, latitude)) <= :distance "
      + "ORDER BY distance LIMIT 10", nativeQuery = true)
  List<StoreSearchResult> findStoreByPointAndRange(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("distance") int distance);
}
