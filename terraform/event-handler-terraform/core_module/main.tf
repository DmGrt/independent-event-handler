# Define resources specific to the Core Module
resource "aws_rds_instance" "core_db" {
  allocated_storage    = 20
  storage_type         = "gp2"
  engine               = "mysql"
  engine_version       = "5.7"
  instance_class       = "db.t2.micro"
  name                 = "core-db"
  username             = "db_user"
  password             = "db_password"
  parameter_group_name = "default.mysql5.7"
  skip_final_snapshot  = true
}

resource "aws_ecs_cluster" "core_cluster" {
  name = "core-cluster"
}

