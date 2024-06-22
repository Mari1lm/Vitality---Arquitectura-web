package com.example.vitality.repositories;

import com.example.vitality.entities.HealthObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHealthObjectiveRepository extends JpaRepository<HealthObjective, Integer> {

    //ITALO
    @Query(value = "SELECT u.username AS Usuarios, COUNT(*) AS Health_objectives \n " +
            "            FROM Users u\n " +
            "            INNER JOIN Health_objective h ON u.id = h.id_user\n " +
            "            GROUP BY u.username ",
            nativeQuery = true)
    List<String[]> findHealthObjectivesByUser();


    //ITALO
    @Query(value = "SELECT u.username, COUNT(h.id_health_objective)\n " +
            "                        FROM health_objective h \n " +
            "                        INNER JOIN users u ON h.id_user=u.id\n " +
            "                        WHERE u.subscription = true \n " +
            "                        GROUP BY u.id, u.username  ",
            nativeQuery = true)
    List<String[]> countHealthObjectivesForSubscribedUsers();


    //MICHEL
    @Query(value = "SELECT U.username, HO.type_objective, MO.status_monitoring\n " +
            "                        FROM health_objective HO\n " +
            "                        INNER JOIN users U\n " +
            "                        ON U.id = HO.id_user\n " +
            "                        INNER JOIN monitoring MO\n " +
            "                        ON MO.id_health_objective = HO.id_health_objective\n " +
            "                        WHERE MO.status_monitoring = 'Finalizado'  ",nativeQuery = true)
    public List<String[]> findObjetiveStatus ();

}
