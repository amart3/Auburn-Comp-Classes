----sign_extend----

force -freeze sim:/sign_extend/input 16'h00ff 0
run 100 ns


force -freeze sim:/sign_extend/input 16'hf005 0
run 100 ns


force -freeze sim:/sign_extend/input 16'hA005 0
run 100 ns


force -freeze sim:/sign_extend/input 16'hABB0 0
run 100 ns


force -freeze sim:/sign_extend/input 16'hff00 0
run 100 ns