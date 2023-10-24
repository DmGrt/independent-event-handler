variable "vpc_id" {
  description = "ID of the VPC where the Kafka module resources will be deployed."
  type        = string
}

variable "subnet_ids" {
  description = "List of subnet IDs where Kafka broker nodes will be placed."
  type        = list(string)
}