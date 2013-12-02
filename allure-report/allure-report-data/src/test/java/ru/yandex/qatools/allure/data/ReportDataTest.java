package ru.yandex.qatools.allure.data;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 21.10.13
 */
public class ReportDataTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void attachmentsListTest() throws Exception {
        assertEquals(
                "Not all attachment files are found.",
                3,
                AllureReportGenerator.getAttachmentsFiles(getTestDataDirs()).length
        );
    }

    @Test
    public void copyAttachmentsTest() throws Exception {
        File outputDirectory = folder.newFolder();
        AllureReportGenerator.copyAttachments(getTestDataDirs(), outputDirectory);
        assertEquals(
                "Not all attachment files are copied.",
                3,
                AllureReportGenerator.getAttachmentsFiles(outputDirectory).length
        );
    }

    public static File[] getTestDataDirs() {
        return new File[]{
                new File(ClassLoader.getSystemResource("testdata1").getFile()),
                new File(ClassLoader.getSystemResource("testdata2").getFile()),
                new File(ClassLoader.getSystemResource("testdata3").getFile())
        };
    }

}

