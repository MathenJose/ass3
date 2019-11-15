
/**
 * RISC-V Instruction Set Simulator
 * 
 * A tiny first step to get the simulator started. Can execute just a single
 * RISC-V instruction.
 * 
 * @author Martin Schoeberl (martin@jopdesign.com)
 *
 */
public class IsaSim {

	static int pc;
	static int reg[] = new int[4];

	// Here the first program hard coded as an array
	static int progr[] = {
			// As minimal RISC-V assembler example
			0x00200093, // addi x1 x0 2
			0x00300113, // addi x2 x0 3
			0x002081b3, // add x3 x1 x2
	};

	public static void main(String[] args) {

		System.out.println("Hello RISC-V World!");

		pc = 0;

		for (;;) {

			int instr = progr[pc];
			int opcode = instr & 0x7f;//leaves first 7 digits
			int rd = (instr >> 7) & 0x01f;// 7bit shift to right and clears everything except for first 5 digits
			int rs1 = (instr >> 15) & 0x01f;
			int rs2 = (instr >> 20) & 0x05f;
			int funct3 = (instr>> 13) & 0x03f;
			int funct7 = (instr>> 23) & 0x07f;
			int imm = (instr >> 20);

			switch (opcode) {

			case 0x13: //
				reg[rd] = reg[rs1] + imm;
				break;
			case 0x23: //
				reg[rd] = reg[rs1] + imm;
				break;
			case 0x63:
				reg[rd] = reg[rs1]+reg[rs2];
				break;
				
			default:
				System.out.println("Opcode " + opcode + " not yet implemented");
				break;
			}
			//when opcode=0x13
			
			switch()
			
			
			//when opcode=0x23
			//when opcode=0x63
			
			
			
			
			
			

			++pc; // We count in 4 byte words
			if (pc >= progr.length) {
				break;
			}
			for (int i = 0; i < reg.length; ++i) {
				System.out.print(reg[i] + " ");
			}
			System.out.println();
		}

		System.out.println("Program exit");

	}

}
