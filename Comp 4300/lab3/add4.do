-----add4-----
force -freeze sim:/add4/input 32'h00000002 0
run 100 ns


force -freeze sim:/add4/input 32'h00000009 0
run 100 ns


force -freeze sim:/add4/input 32'h0000060A 0
run 100 ns


force -freeze sim:/add4/input 32'h00000FFe 0
run 100 ns