# Configure providers
provider "aws" {
  region = "us-west-2"
}

module "event_processing" {
  source = "./event_processing_module"
}

module "api" {
  source = "./api_module"
}

module "kafka" {
  source = "./kafka_module"
}

module "core" {
  source = "./core_module"
}