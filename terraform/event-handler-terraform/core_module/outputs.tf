output "core_db_endpoint" {
  description = "Endpoint of the Core database."
  value       = aws_rds_instance.core_db.endpoint
}

