package com.acme.tictactoe.viewmodel;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

import com.acme.tictactoe.model.Board;
import com.acme.tictactoe.model.Player;

public class TicTacToeViewModel implements ViewModel {

    private Board model;

    public final ObservableArrayMap<String, String> cells = new ObservableArrayMap<>(); // é um mapa
    public final ObservableField<String> winner = new ObservableField<>();

    public TicTacToeViewModel() {
        model = new Board();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void onResetSelected() {
        model.restart(); //
        winner.set(null); // winner é um play
        cells.clear(); // limpa a janela da interface
    }
        // model tem uma classe
    public void onClickedCellAt(int row, int col) { // metodo que
        Player playerThatMoved = model.mark(row, col);
        cells.put("" + row + col, playerThatMoved == null ? null : playerThatMoved.toString());
        winner.set(model.getWinner() == null ? null : model.getWinner().toString());
    }

}
