----dlx_register----

force -freeze sim:/dlx_register/clock 0 0
force -freeze sim:/dlx_register/in_val 32'h55555555 0
run 100 ns



force -freeze sim:/dlx_register/clock 1 0
force -freeze sim:/dlx_register/in_val 32'h55555555 0
run 100 ns



force -freeze sim:/dlx_register/clock 0 0
force -freeze sim:/dlx_register/in_val 32'hAAAAAAAA 0
run 100 ns


force -freeze sim:/dlx_register/clock 1 0
force -freeze sim:/dlx_register/in_val 32'hAAAAAAAA 0
run 100 ns


force -freeze sim:/dlx_register/clock 0 0
force -freeze sim:/dlx_register/in_val 32'hFFFFFFFF 0
run 100 ns

force -freeze sim:/dlx_register/clock 1 0
force -freeze sim:/dlx_register/in_val 32'hFFFFFFFF 0
run 100 ns