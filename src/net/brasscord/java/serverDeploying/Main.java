package net.brasscord.java.serverDeploying;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main extends JFrame{

    Main()
    {
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        String[] versions = {"1.7.10","1.12.2","1.14.4","1.15.2","1.16.5","1.17.1","1.18.2"};
        String[] versionsMod = {"1.7.10 Forge","1.7.10 Vanilla",
                "1.12.2 Forge","1.12.2 Vanilla",
                "1.14.4 Forge","1.14.4 Fabric","1.14.4 Vanilla",
                "1.15.2 Forge","1.15.2 Fabric","1.15.2 Vanilla",
                "1.16.5 Forge","1.16.5 Fabric","1.16.5 Vanilla",
                "1.17.1 Forge","1.17.1 Fabric","1.17.1 Vanilla",
                "1.18.2 Forge","1.18.2 Fabric","1.18.2 Vanilla"};

        JButton deploy = new JButton("Start Vanilla Server");
        deploy.setBounds(65,30,240,40);
        JButton deployForge = new JButton("Start Forge Server");
        deployForge.setBounds(65, 80,240,40);
        JButton deployFabric = new JButton("Start Fabric Server");
        deployFabric.setBounds(65,130,240,40);
        JButton acceptEula = new JButton("Accept EULA");
        acceptEula.setBounds(65,180,240,40);
        JButton openServerFolder = new JButton("Open Server Files");
        openServerFolder.setBounds(65,230,240,40);
        JButton editServerProperties = new JButton("Edit Server.properties");
        editServerProperties.setBounds(65,280,240,40);
        JComboBox<String> versionBox = new JComboBox<>(versions);
        versionBox.setBounds(65,330,100,20);
        JButton setVersion = new JButton("Set Version");
        setVersion.setBounds(180,330,120,20);
        JComboBox<String> downloadVersion = new JComboBox<>(versionsMod);
        downloadVersion.setBounds(65,355,100,20);
        JButton download = new JButton("Download Files");
        download.setBounds(180,355,120,20);
        JButton selectDirect = new JButton("Select Directory");
        selectDirect.setBounds(65,380,235,20);
        JLabel setDirectory = new JLabel("No Directory Chosen");
        setDirectory.setBounds(65,400,235,20);

        frame.add(deploy);
        frame.add(deployForge);
        frame.add(deployFabric);
        frame.add(acceptEula);
        frame.add(openServerFolder);
        frame.add(editServerProperties);
        frame.add(versionBox);
        frame.add(setVersion);
        frame.add(downloadVersion);
        frame.add(download);
        frame.add(selectDirect);
        frame.add(setDirectory);

        frame.setSize(380,480);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quick MC server deployer");

        final File[] savedFile = new File[1];

        deploy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("no");
                System.out.println(savedFile[0] + " It works");
            }
        });
        deployForge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("maybe");
            }
        });
        deployFabric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yes");
            }
        });
        acceptEula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Eula Accepted");
            }
        });
        openServerFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opened Folder");
            }
        });
        editServerProperties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opened Server Properties");
            }
        });
        versionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Good Choice!");
            }
        });
        downloadVersion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Running");
            }
        });
        selectDirect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Select a directory");
                JFileChooser DirectoryPicker = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                DirectoryPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int r = DirectoryPicker.showOpenDialog(frame);

                if(r == JFileChooser.APPROVE_OPTION) {
                    savedFile[0] = DirectoryPicker.getSelectedFile();
                    System.out.println("Saved File " + savedFile[0].getAbsolutePath());
                    setDirectory.setText(DirectoryPicker.getSelectedFile().getAbsolutePath());
                }
            }
        });

    }
}