variable "vpc_id" {
  description = "ID of the VPC where the API module resources will be deployed."
  type        = string
}

variable "subnet_id" {
  description = "ID of the subnet where the API instance will be deployed."
  type        = string
}