package org.example.problems.solving.pickupItem.dto;

public record PickUpItemInput(
	int[][] rectangle,
	int characterX,
	int characterY,
	int itemX,
	int itemY
) {
}
