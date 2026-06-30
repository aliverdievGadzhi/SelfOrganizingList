package org.example;

public class Main {
  public static void main(String[] args) {

    // --- Transpose Strategy ---
    System.out.println("=== TRANSPOSE STRATEGY ===");
    SelfOrganizingList<String> techStackTranspose = new TransposeListIterative<>(
            new String[]{"Java", "Gradle", "Git", "Docker"}
    );

    System.out.println("Initial:      " + techStackTranspose); // Java -> Gradle -> Git -> Docker
    techStackTranspose.contains("Git");
    System.out.println("After search: " + techStackTranspose); // Java -> Git -> Gradle -> Docker

    System.out.println("\n" + "=".repeat(50) + "\n");

    // --- Move-To-Front (MTF) Strategy ---
    System.out.println("=== MOVE-TO-FRONT (MTF) STRATEGY ===");
    SelfOrganizingList<String> techStackMTF = new MoveToFrontListIterative<>(
            new String[]{"Java", "Gradle", "Git", "Docker"}
    );

    System.out.println("Initial:      " + techStackMTF); // Java -> Gradle -> Git -> Docker
    techStackMTF.contains("Git");
    System.out.println("After search: " + techStackMTF); // Git -> Java -> Gradle -> Docker
  }
}