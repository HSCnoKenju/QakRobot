%====================================================================================
% basic_robot_system description   
%====================================================================================
context(ctx_basic_robot, "127.0.0.1",  "TCP", "8020").
 qactor( basic_robot, ctx_basic_robot, "it.unibo.basic_robot.Basic_robot").
  qactor( mapper_boundary, ctx_basic_robot, "it.unibo.mapper_boundary.Mapper_boundary").
