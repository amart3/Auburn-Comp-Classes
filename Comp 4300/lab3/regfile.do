---regfile---

force -freeze sim:/regfile/clock 0 0
force -freeze sim:/regfile/data_in 32'h55555555 0
force -freeze sim:/regfile/read_notwrite 0 0
force -freeze sim:/regfile/regA 5'h00 0
force -freeze sim:/regfile/regB 5'h00 0
run 100 ns


force -freeze sim:/regfile/clock 1 0
force -freeze sim:/regfile/data_in 32'h55555555 0
force -freeze sim:/regfile/read_notwrite 0 0
force -freeze sim:/regfile/regA 5'h00 0
force -freeze sim:/regfile/regB 5'h00 0
run 100 ns


force -freeze sim:/regfile/clock 0 0
force -freeze sim:/regfile/data_in 32'h55555555 0
force -freeze sim:/regfile/read_notwrite 1 0
force -freeze sim:/regfile/regA 5'h00 0
force -freeze sim:/regfile/regB 5'h03 0
run 100 ns



force -freeze sim:/regfile/clock 1 0
force -freeze sim:/regfile/data_in 32'h55555555 0
force -freeze sim:/regfile/read_notwrite 1 0
force -freeze sim:/regfile/regA 5'h00 0
force -freeze sim:/regfile/regB 5'h03 0
run 100 ns


force -freeze sim:/regfile/clock 0 0
force -freeze sim:/regfile/data_in 32'hFFFFFFFF 0
force -freeze sim:/regfile/read_notwrite 0 0
force -freeze sim:/regfile/regA 5'h03 0
force -freeze sim:/regfile/regB 5'h00 0
run 100 ns


force -freeze sim:/regfile/clock 1 0
force -freeze sim:/regfile/data_in 32'hFFFFFFFF 0
force -freeze sim:/regfile/read_notwrite 0 0
force -freeze sim:/regfile/regA 5'h02 0
force -freeze sim:/regfile/regB 5'h00 0
run 100 ns


force -freeze sim:/regfile/clock 0 0
force -freeze sim:/regfile/data_in 32'hFFFFFFFF 0
force -freeze sim:/regfile/read_notwrite 1 0
force -freeze sim:/regfile/regA 5'h02 0
force -freeze sim:/regfile/regB 5'h00 0
run 100 ns



force -freeze sim:/regfile/clock 0 0
force -freeze sim:/regfile/data_in 32'hFFFFFFFF 0
force -freeze sim:/regfile/read_notwrite 1 0
force -freeze sim:/regfile/regA 5'h02 0
force -freeze sim:/regfile/regB 5'h00 0
run 100 ns


force -freeze sim:/regfile/clock 1 0
force -freeze sim:/regfile/data_in 32'hFFFFFFFF 0
force -freeze sim:/regfile/read_notwrite 1 0
force -freeze sim:/regfile/regA 5'h02 0
force -freeze sim:/regfile/regB 5'h00 0
run 100 ns












