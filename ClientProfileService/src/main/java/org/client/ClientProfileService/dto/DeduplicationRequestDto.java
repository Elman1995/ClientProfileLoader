package org.client.ClientProfileService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeduplicationRequestDto {
	private String event;

	private String icp;

	private String icpDuplicate;
}
