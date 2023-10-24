resource "aws_msk_cluster" "kafka_cluster" {
  cluster_name    = "my-kafka-cluster"
  kafka_version   = "2.8.0"
  number_of_broker_nodes = 3
  broker_node_group_info {
    instance_type = "kafka.m5.large"
    client_subnets = [var.subnet_ids]
  }
  encryption_info {
    encryption_in_transit {
      client_broker = "PLAINTEXT"
    }
  }
  storage_info {
    ebs_storage_info {
      volume_size = 1000
    }
  }
}

resource "aws_security_group" "kafka_sg" {
  name_prefix   = "kafka-sg-"
  description   = "Kafka Module Security Group"
  vpc_id        = var.vpc_id

  # Define inbound and outbound rules for your Kafka cluster
  # ...
}