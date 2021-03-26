----------------------------------------
	--- Begin dlx_register--- 
----------------------------------------
use work.dlx_types.all;
use work.bv_arithmetic.all;

entity dlx_register is
	generic(prop_delay: Time := 5 ns);
	port(in_val: in dlx_word; clock: in bit; out_val: out
	dlx_word);
end entity dlx_register;

architecture behavior1 of dlx_register is 

begin 
		
	dlx_register: process(in_val, clock) is

	begin 
	
	if (clock = '1') then 
		out_val <= in_val after prop_delay; 

	end if;

	end process dlx_register; 

end architecture behavior1;
----------------------------------------
	--- End dlx_register ---
----------------------------------------


----------------------------------------
	--- Begin mux ---
----------------------------------------
use work.dlx_types.all;
use work.bv_arithmetic.all;

entity mux is
	generic(prop_delay: Time := 5 ns);
	port (input_1,input_0 : in dlx_word; which: in bit;
	output: out dlx_word);
end entity mux;

architecture behavior2 of mux is 

begin 
	mux: process(input_1, input_0, which) is

	begin
	
	if which = '0' then 
		output <= input_0 after prop_delay; 
	else
		output <= input_1 after prop_delay;
	
	end if; 
	
	end process mux; 

end architecture behavior2;  
----------------------------------------
	--- End mux ---
----------------------------------------


----------------------------------------
	--- Begin sign_extend ---
----------------------------------------
use work.dlx_types.all;
use work.bv_arithmetic.all;

entity sign_extend is
	generic(prop_delay: Time := 5 ns); 
	port (input: in half_word; output: out dlx_word);
end entity sign_extend;

architecture behavior3 of sign_extend is 

begin 
	sign_extend: process(input) 

	begin 
	
	output <= bv_sext(input, 32) after prop_delay; 
	
	end process sign_extend; 

end architecture behavior3;
----------------------------------------
	--- End sign_extend ---
----------------------------------------


----------------------------------------
	--- Begin add4 ---
----------------------------------------
use work.dlx_types.all;
use work.bv_arithmetic.all;

entity add4 is
	generic(prop_delay: Time:= 5 ns); 
	port (input: in dlx_word; output: out dlx_word);
end entity add4;

architecture behavior4 of add4 is 

begin 
	add4: process(input) 

		variable result: dlx_word; 
		variable overFlow: boolean := false; 
	
	begin 
		bv_addu(input, x"00000004", result, overFlow);
		output <= result after prop_delay; 
	
	end process add4; 

end architecture behavior4; 
----------------------------------------
	--- End add4 ---
----------------------------------------


----------------------------------------
	--- Begin regfile ---
----------------------------------------
use work.dlx_types.all;
use work.bv_arithmetic.all;

entity regfile is
	generic(prop_delay: Time:= 5 ns); 
	port (read_notwrite,clock : in bit;
		regA,regB: in register_index;
		data_in: in dlx_word;
		dataA_out,dataB_out: out dlx_word
		);
end entity regfile;

architecture behavior5 of regfile is
	
	
	type regArray is array (0 to 31) of dlx_word;
	signal regArray2: regArray;

begin
	
	reg: process(read_notwrite, clock, regA, regB, data_in) is
	begin
		
		if (clock = '1') then
			
			if (read_notwrite = '1') then

				dataA_out <= regArray2(bv_to_natural(regA)) after prop_delay;
				dataB_out <= regArray2(bv_to_natural(regB)) after prop_delay;
			else
				regArray2(bv_to_natural(regA)) <= data_in after prop_delay; 
			end if;
		end if;

	end process reg;

end architecture behavior5;
----------------------------------------
	--- End regfile ---
----------------------------------------
	


















	