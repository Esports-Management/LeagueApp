package com.example.esportsmanagement.user.jpa.data.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDataResponse<T> {
    private List<T> data;
}
