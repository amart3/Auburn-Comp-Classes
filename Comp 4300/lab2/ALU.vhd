use work.dlx_types.all;
use work.bv_arithmetic.all;

entity ALU is 
	generic(prop_delay: Time := 5 ns);
	port(operand1, operand2: in dlx_word; operation: in alu_operation_code;
 	signed: in bit;
 	result: out dlx_word; error: out error_code);
 end entity ALU;

architecture behaviour1 of ALU is 

begin 	

		ALU : process(operand1, operand2, operation, signed) 
		variable overFlow: boolean := false; 
		variable assignResult: dlx_word; 
		
		begin
	
		case operation is 

			when "0000" => 
				--- ADD
				if signed = '1' then 
					bv_add(operand1, operand2, assignResult, overFlow); 
				else 
					bv_addu(operand1, operand2, assignResult, overFlow); 
				end if; 
				if overFLow then 
					error <= "0001" after prop_delay; 
				else error <= "0000" after prop_delay; 
				end if; 
			
			when "0001" => 
				--- SUB
				if signed = '1' then 
					bv_sub(operand1, operand2, assignResult, overFlow); 
				else 
					bv_subu(operand1, operand2, assignResult, overFlow); 
				end if; 
				if overFLow then 
					error <= "0001" after prop_delay; 
				else error <= "0000" after prop_delay; 
				end if; 
					
			when "0010" => 
				--- AND
			error <= "0000" after prop_delay; 
			for i in 31 downto 0 loop 
				assignResult :=  operand1 and operand2; 
			end loop; 
			result <= assignResult after prop_delay; 


			when "0011" => 
				--- OR
				error <= "0000" after prop_delay; 
			for i in 31 downto 0 loop 
				assignResult :=  operand1 or operand2; 
			end loop; 
			result <= assignResult after prop_delay; 

			
			when "0100" => 
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay;
 

			when "0101" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 

			when "0110" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 


			when "0111" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 

			when "1000" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 

			when "1001" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 
			
			when "1010" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 


			
			when "1011" => 
				--- SLT
				if operand1 < operand2 then 
					assignResult := x"00000001";

						result <= assignResult;
				else 		
					assignResult := x"00000000";
						result <= assignResult;
				
				end if; 

			when "1100" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 

			when "1101" =>
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 

			
			
			when "1110" => 
				--- MUL 
				if signed = '1' then 
					bv_mult(operand1, operand2, assignResult, overFlow); 
				else 
					bv_multu(operand1, operand2, assignResult, overFlow); 
				end if; 
				if overFLow then 
					error <= "0001" after prop_delay; 
				else error <= "0000" after prop_delay; 
				end if; 
					


			when "1111" => 
			error <= "0000" after prop_delay;
			result <= assignResult after prop_delay; 


			when others => 
				assignResult := x"00000000";

			end case; 

			if overFlow then 
				error <= "0001" after prop_delay; 
			else error <= "0000" after prop_delay; 
			end if; 
			result <= assignResult after prop_delay;

	end process;
 
end architecture behaviour1;
			
			