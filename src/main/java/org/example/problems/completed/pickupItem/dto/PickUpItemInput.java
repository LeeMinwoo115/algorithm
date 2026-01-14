package org.example.problems.completed.pickupItem.dto;

public record PickUpItemInput(
	int[][] rectangle,
	int characterX,
	int characterY,
	int itemX,
	int itemY
) {
}
