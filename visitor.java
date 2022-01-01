
public class visitor extends lab2BaseVisitor<Void> {
    // public PrintStream ps = new PrintStream(new FileOutputStream(main.output_path));
    public static String exp = "";

//    public visitor() throws FileNotFoundException {
//        System.out.print("lllll ");
//    }

    @Override
    public Void visitCompUnit(lab2Parser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }

    @Override
    public Void visitFuncDef(lab2Parser.FuncDefContext ctx) {
        System.out.print("define dso_local ");
        return super.visitFuncDef(ctx);
    }

    @Override
    public Void visitFuncType(lab2Parser.FuncTypeContext ctx) {
        System.out.print("i32 ");
        return null;
    }

    @Override
    public Void visitIdent(lab2Parser.IdentContext ctx) {
        System.out.print("@main() ");
        return null;
    }

    @Override
    public Void visitBlock(lab2Parser.BlockContext ctx) {
        System.out.println("{");
        visit(ctx.stmt());
        System.out.println("}");
        return null;
    }

    @Override
    public Void visitStmt(lab2Parser.StmtContext ctx) {
        //System.out.print("  ret ");
         visit(ctx.exp());
//       new PostfixExpression().func(exp);
        return null;
       // return super.visitStmt(ctx);
    }

    @Override
    public Void visitNumber(lab2Parser.NumberContext ctx) {
        int number = 0;
        if (ctx.decimalconst() != null) {
            number = Integer.parseInt(ctx.decimalconst().toString());
        } else if (ctx.octalconst() != null) {
            String oct = ctx.octalconst().toString();
            number = Integer.valueOf(oct, 8);
        } else {
            String hex = ctx.hexadecimalconst().toString().substring(2);
            number =Integer.valueOf(hex, 16);
        }
        System.out.print(number);
        return super.visitNumber(ctx);
    }

    @Override
    public Void visitExp(lab2Parser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    @Override
    public Void visitAddexp(lab2Parser.AddexpContext ctx){
        return super.visitAddexp(ctx);
    }


    @Override
    public Void visitMulexp(lab2Parser.MulexpContext ctx) {
        return super.visitMulexp(ctx);
    }
    @Override
    public Void visitUnaryexp(lab2Parser.UnaryexpContext ctx) {
        return super.visitUnaryexp(ctx);
    }

    @Override
    public Void visitPrimaryexp(lab2Parser.PrimaryexpContext ctx) {
        if (ctx.number() != null) {
            visit(ctx.number());
        } else {
            exp += "(";
            visit(ctx.exp());
            exp += ")";
        }
        return null;
    }

    @Override
    public Void visitUnaryop(lab2Parser.UnaryopContext ctx) {
        exp += ctx.getText();
        return super.visitUnaryop(ctx);
    }
    @Override
    public Void visitDecimalconst(lab2Parser.DecimalconstContext ctx) {
        return super.visitDecimalconst(ctx);
    }

    @Override
    public Void visitOctalconst(lab2Parser.OctalconstContext ctx) {
        return super.visitOctalconst(ctx);
    }

    @Override
    public Void visitHexadecimalconst(lab2Parser.HexadecimalconstContext ctx) {
        return super.visitHexadecimalconst(ctx);
    }

    @Override
    public Void visitHexadecimalprefix(lab2Parser.HexadecimalprefixContext ctx) {
        return super.visitHexadecimalprefix(ctx);
    }

    @Override
    public Void visitNonzerodigit(lab2Parser.NonzerodigitContext ctx) {
        return super.visitNonzerodigit(ctx);
    }

    @Override
    public Void visitOctaldigit(lab2Parser.OctaldigitContext ctx) {
        return super.visitOctaldigit(ctx);
    }

    @Override
    public Void visitDigit(lab2Parser.DigitContext ctx) {
        return super.visitDigit(ctx);
    }

    @Override
    public Void visitHexadecimaldigit(lab2Parser.HexadecimaldigitContext ctx) {
        return super.visitHexadecimaldigit(ctx);
    }
}


