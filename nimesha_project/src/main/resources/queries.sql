CREATE TABLE discovered_services (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(50) NOT NULL,
    result TEXT,
    status VARCHAR(20)
);

CREATE TABLE s3_buckets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_id INT,
    bucket_name VARCHAR(100) NOT NULL,
    file_name VARCHAR(255) NOT NULL
);

CREATE TABLE ec2_instances (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_id INT,
    instance_id VARCHAR(50) NOT NULL
);

