output "event_processing_cluster_id" {
  description = "ID of the Event Processing ECS cluster."
  value       = aws_ecs_cluster.event_processing_cluster.id
}