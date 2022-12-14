package com.example.esportsmanagement.user.jpa.data.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDataResponse<T> {

    private List<T> data;
}
