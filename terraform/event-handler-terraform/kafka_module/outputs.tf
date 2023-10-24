output "kafka_cluster_arn" {
  description = "Amazon MSK cluster ARN."
  value       = aws_msk_cluster.kafka_cluster.arn
}