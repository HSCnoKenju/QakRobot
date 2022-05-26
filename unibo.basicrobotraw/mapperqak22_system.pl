%====================================================================================
% mapperqak22_system description   
%====================================================================================
context(ctx_mapperqak22, "localhost",  "TCP", "8030").
context(ctxbasicrobot, "127.0.0.1",  "TCP", "8020").
 qactor( basicrobot, ctxbasicrobot, "external").
  qactor( mapperqak22, ctx_mapperqak22, "it.unibo.mapperqak22.Mapperqak22").
