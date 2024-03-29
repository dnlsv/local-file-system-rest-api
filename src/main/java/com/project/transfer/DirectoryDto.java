package com.project.transfer;

import com.project.models.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Directory data transfer object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectoryDto {

    /**
     * Directory name
     */
    private String name;

    /**
     * Method for getting directory DTO by file
     *
     * @param file file
     * @return directory dto like {@link DirectoryDto}
     */
    public static DirectoryDto from(File file) {
        return DirectoryDto.builder()
                .name(file.getName())
                .build();
    }

    /**
     * Method for getting DTO directory list by file list
     *
     * @param files list of files
     * @return DTO directory list like {@link List}
     */
    public static List<DirectoryDto> from(List<File> files) {
        return files.stream().map(DirectoryDto::from).collect(Collectors.toList());
    }
}
