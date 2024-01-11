import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiscoveryController {

    @Autowired
    private DiscoveryService discoveryService;

    @PostMapping("/discoverServices")
    public ResponseEntity<String> discoverServices(@RequestBody List<String> services) {
        String jobId = discoveryService.discoverServices(services);
        return ResponseEntity.ok(jobId);
    }

    @GetMapping("/getJobResult/{jobId}")
    public ResponseEntity<String> getJobResult(@PathVariable String jobId) {
        String result = discoveryService.getJobResult(jobId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getDiscoveryResult/{service}")
    public ResponseEntity<List<String>> getDiscoveryResult(@PathVariable String service) {
        List<String> discoveryResult = discoveryService.getDiscoveryResult(service);
        return ResponseEntity.ok(discoveryResult);
    }

    @GetMapping("/getS3BucketObjects/{bucketName}")
    public ResponseEntity<String> getS3BucketObjects(@PathVariable String bucketName) {
        String jobId = discoveryService.getS3BucketObjects(bucketName);
        return ResponseEntity.ok(jobId);
    }

    @GetMapping("/getS3BucketObjectCount/{bucketName}")
    public ResponseEntity<Integer> getS3BucketObjectCount(@PathVariable String bucketName) {
        int count = discoveryService.getS3BucketObjectCount(bucketName);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/getS3BucketObjectLike/{bucketName}/{pattern}")
    public ResponseEntity<List<String>> getS3BucketObjectLike(@PathVariable String bucketName,
                                                              @PathVariable String pattern) {
        List<String> matchingFiles = discoveryService.getS3BucketObjectLike(bucketName, pattern);
        return ResponseEntity.ok(matchingFiles);
    }
}

