import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DatabaseRepository extends JpaRepository<DiscoveredService, Long> {

    @Modifying
    @Query("INSERT INTO ec2_instances (job_id, instance_id) VALUES (:jobId, :instanceId)")
    void saveEC2Instance(@Param("jobId") String jobId, @Param("instanceId") String instanceId);

    @Modifying
    @Query("INSERT INTO s3_buckets (job_id, bucket_name) VALUES (:jobId, :bucketName)")
    void saveS3Bucket(@Param("jobId") String jobId, @Param("bucketName") String bucketName);

    // Additional methods for other database operations
}

