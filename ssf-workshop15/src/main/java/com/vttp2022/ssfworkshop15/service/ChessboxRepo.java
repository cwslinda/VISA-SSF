package com.vttp2022.ssfworkshop15.service;

import com.vttp2022.ssfworkshop15.model.ChessMain;

public interface ChessboxRepo {
    public void save(final ChessMain chessbox);

    public ChessMain findById(final String chessId);
}

