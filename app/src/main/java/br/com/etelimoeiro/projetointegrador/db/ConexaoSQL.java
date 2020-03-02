package br.com.etelimoeiro.projetointegrador.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexaoSQL extends SQLiteOpenHelper {

    private static ConexaoSQL INSTANCIA_CONEXAO;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "projeto_integradorapp";

    public ConexaoSQL(@Nullable Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    public static ConexaoSQL getInstancia(Context context) {
        if (INSTANCIA_CONEXAO == null) {
            INSTANCIA_CONEXAO = new ConexaoSQL(context);
        }
        return INSTANCIA_CONEXAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaProduto =
                "CREATE TABLE IF NOT EXISTS tbproduto " +
                        "(" +
                        "id INTEGER PRIMARY KEY, " +
                        "nome TEXT," +
                        "qtd INTEGER," +
                        "valor REAL " +
                        ")";

        db.execSQL(sqlTabelaProduto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
