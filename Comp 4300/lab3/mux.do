----mux----

force -freeze sim:/mux/input_1 32'h00000001 0
force -freeze sim:/mux/input_0 32'h00000000 0
force -freeze sim:/mux/which 0 0
run 100 ns



force -freeze sim:/mux/input_1 32'h00000001 0
force -freeze sim:/mux/input_0 32'h00000000 0
force -freeze sim:/mux/which 1 0
run 100 ns



force -freeze sim:/mux/input_1 32'h00000000 0
force -freeze sim:/mux/input_0 32'h00000001 0
force -freeze sim:/mux/which 0 0
run 100 ns



force -freeze sim:/mux/input_1 32'h00000000 0
force -freeze sim:/mux/input_0 32'h00000001 0
force -freeze sim:/mux/which 1 0
run 100 ns



force -freeze sim:/mux/input_1 32'h0000000F 0
force -freeze sim:/mux/input_0 32'h00000008 0
force -freeze sim:/mux/which 0 0
run 100 ns



force -freeze sim:/mux/input_1 32'h0000000F 0
force -freeze sim:/mux/input_0 32'h00000008 0
force -freeze sim:/mux/which 1 0
run 100 ns