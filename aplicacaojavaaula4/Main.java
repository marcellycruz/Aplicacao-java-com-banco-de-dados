package aplicacaojavaaula4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiceDao serviceDao = new ServiceDao();
        
        System.out.println("Lista de servicos cadastrados do tipo 'banho':");
        listarBanhos(serviceDao);
    
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nCadastro de novo servico:");
        System.out.print("IDService: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("PetName: ");
        String petName = scanner.nextLine();
        
        System.out.print("OwnerName: ");
        String ownerName = scanner.nextLine();
        
        System.out.print("Duration: ");
        int duration = scanner.nextInt();
        
        System.out.print("Price: ");
        double price = scanner.nextDouble();


        Bath novoBanho = new Bath(id, petName, ownerName, price, duration);
        
        if (serviceDao.insertBath(id ,novoBanho)) {
            System.out.println("\nNovo servico de banho cadastrado com sucesso");
        } else {
            System.out.println("\nFalha ao cadastrar o servico.");
        }

    
        System.out.println("\nLista de servicos cadastrados após a insercao:");
        listarBanhos(serviceDao);

        scanner.close();
    }

    private static void listarBanhos(ServiceDao serviceDao) {
        ArrayList<Bath> banhos = serviceDao.getAllBath();
        
        for (Bath bath : banhos) {
            System.out.println("\nIDService: " + bath.getId());
            System.out.println("PetName: " + bath.getPetName());
            System.out.println("OwnerName: " + bath.getOwnerName());
            System.out.println("Service: banho");
            System.out.println("Duration: " + bath.getDuration() + " m");
            System.out.println("Price: R$ " + bath.getPrice());
        }
    }
}
