# Define resources specific to the Event Processing Module
resource "aws_ecs_cluster" "event_processing_cluster" {
  name = "event-processing-cluster"
  capacity_providers = ["FARGATE"]
}

resource "aws_ecs_task_definition" "event_processing_task" {
  family                   = "event-processing-task"
  network_mode             = "awsvpc"
  requires_compatibilities = ["FARGATE"]
  execution_role_arn        = aws_iam_role.event_processing_execution_role.arn

  container_definitions = jsonencode([{
    name  = "event-processor",
    image = "your-event-processor-image:latest",
    portMappings = [{
      containerPort = 8080,
      hostPort      = 8080
    }]
  }])
}

resource "aws_iam_role" "event_processing_execution_role" {
  name = "event-processing-execution-role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17",
    Statement = [{
      Action = "sts:AssumeRole",
      Effect = "Allow",
      Principal = {
        Service = "ecs-tasks.amazonaws.com"
      }
    }]
  })
}

resource "aws_security_group" "event_processing_sg" {
  name_prefix = "event-processing-sg-"
  description = "Event Processing Module Security Group"
  vpc_id      = var.vpc_id
}