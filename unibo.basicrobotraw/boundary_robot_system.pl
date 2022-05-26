%====================================================================================
% boundary_robot_system description   
%====================================================================================
context(ctx_boundary_robot, "localhost",  "TCP", "8030").
 qactor( boundary_planner, ctx_boundary_robot, "it.unibo.boundary_planner.Boundary_planner").
